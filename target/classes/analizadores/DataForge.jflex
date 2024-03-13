package analizadores;

import errores.ErrorLexico;
import java_cup.runtime.Symbol;
import utilidades.Token;
import java.util.LinkedList;

%%
%class Lexico
%public
%line
%char
%cup
%unicode
%ignorecase

%{
    public LinkedList<ErrorLexico> lexicalErrors;
    public LinkedList<Token> tokens;
%}

%init{
lexicalErrors = new LinkedList<>();
tokens = new LinkedList<>();
    yyline = 1;
    yychar = 1;
%init}

BLANK = [ \r\t]+
COMMENTONELINE = ("!".*\r\n)|("!".*\n)|("!".*\r)
COMMENTMULTILINE = "<!""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"!>"

CHAR = [\"][^\"]*[\"]
DOUBLE = [0-9]+("."[  |0-9]+)?


ID = [A-Za-z]+["_"0-9A-Za-z]*
TYPEDEF = double|char[]

%%


"PROGRAM"                  {tokens.add(new Token(yytext(), "palabraReservada", yytext(), yyline, yychar)); return new Symbol(sym.PROGRAM,yyline,(int) yychar, yytext());}
"END PROGRAM"                  {tokens.add(new Token(yytext(), "palabraReservada", yytext(), yyline, yychar)); return new Symbol(sym.ENDPROGRAM,yyline,(int) yychar, yytext());}
"var"           {tokens.add(new Token(yytext(), "palabraReservada", yytext(), yyline, yychar)); return new Symbol(sym.VAR,yyline,(int) yychar, yytext());}
":"             {tokens.add(new Token(yytext(), "simbolo dos puntos", yytext(), yyline, yychar)); return new Symbol(sym.DOSPUNTOS,yyline,(int) yychar, yytext());}
"::"             {tokens.add(new Token(yytext(), "simbolo dos puntos seguidos", yytext(), yyline, yychar)); return new Symbol(sym.DOSPUNTOSSEGUIDOS,yyline,(int) yychar, yytext());}
"end;"             {tokens.add(new Token(yytext(), "palabraReservada", yytext(), yyline, yychar)); return new Symbol(sym.END,yyline,(int) yychar, yytext());}
"<-"             {tokens.add(new Token(yytext(), "simbolo de asignacion", yytext(), yyline, yychar)); return new Symbol(sym.ASIGNACION,yyline,(int) yychar, yytext());}
"arr"             {tokens.add(new Token(yytext(), "palabraReservada", yytext(), yyline, yychar)); return new Symbol(sym.ARREGLO,yyline,(int) yychar, yytext());}
"@"             {tokens.add(new Token(yytext(), "simbolo de arroba", yytext(), yyline, yychar)); return new Symbol(sym.ARROBA,yyline,(int) yychar, yytext());}
"console"             {tokens.add(new Token(yytext(), "palabraReservada", yytext(), yyline, yychar)); return new Symbol(sym.CONSOLE,yyline,(int) yychar, yytext());}
"print"             {tokens.add(new Token(yytext(), "palabraReservada", yytext(), yyline, yychar)); return new Symbol(sym.PRINT,yyline,(int) yychar, yytext());}
"="             {tokens.add(new Token(yytext(), "simbolo igual", yytext(), yyline, yychar)); return new Symbol(sym.IGUAL,yyline,(int) yychar, yytext());}
","             {tokens.add(new Token(yytext(), "simbolo de coma", yytext(), yyline, yychar)); return new Symbol(sym.COMA,yyline,(int) yychar, yytext());}

\n                      {yychar=1;}
{BLANK}                 {}
{COMMENTONELINE}        {}
{COMMENTMULTILINE}      {}

{DOUBLE}                   {tokens.add(new Token("numero", "variable double", yytext(), yyline, yychar)); return new Symbol(sym.DOUBLE,yyline,(int) yychar, yytext());}
{CHAR}                    {tokens.add(new Token("cadena", "variable string", yytext(), yyline, yychar)); return new Symbol(sym.CHAR,yyline,(int) yychar, yytext());}

{TYPEDEF}               {tokens.add(new Token("tipo", "tipo de variable", yytext(), yyline, yychar)); return new Symbol(sym.TYPEDEF,yyline,(int) yychar, yytext());}
{ID}                    {tokens.add(new Token("id", "tipo id", yytext(), yyline, yychar)); return new Symbol(sym.ID,yyline,(int) yychar, yytext());}

. {
    lexicalErrors.add(new ErrorLexico("Lexico", "Caracter no valido detectado: " + yytext(), yyline+"" , yychar+"" ));
}