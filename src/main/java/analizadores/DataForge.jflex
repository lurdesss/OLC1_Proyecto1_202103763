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
COMMENTONELINE = "!"[^\r\n]*((\r\n)|\r|\n)
COMMENTMULTILINE = "<!"([^!]|"!"[^>])*"!>"

CHAR = [\"][^\"]*[\"]
DOUBLE = [0-9]+("."[  |0-9]+)?


ID = [A-Za-z]+["_"0-9A-Za-z]*
TYPEDEF = double|char[]

%%


"PROGRAM"       {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.PROGRAM,yyline,(int) yychar, yytext());}
"END PROGRAM"   {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.ENDPROGRAM,yyline,(int) yychar, yytext());}
"end;"          {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.END,yyline,(int) yychar, yytext());}
"var"           {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.VAR,yyline,(int) yychar, yytext());}
"console"       {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.CONSOLE,yyline,(int) yychar, yytext());}
"print"         {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.PRINT,yyline,(int) yychar, yytext());}
"arr"           {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.ARREGLO,yyline,(int) yychar, yytext());}
"column"        {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.COLUMN,yyline,(int) yychar, yytext());}
":"             {tokens.add(new Token(yytext(), "simbolo dos puntos", yytext(), yyline, yychar)); return new Symbol(sym.DOSPUNTOS,yyline,(int) yychar, yytext());}
"::"            {tokens.add(new Token(yytext(), "simbolo dos puntos seguidos", yytext(), yyline, yychar)); return new Symbol(sym.DOSPUNTOSSEGUIDOS,yyline,(int) yychar, yytext());}
"<-"            {tokens.add(new Token(yytext(), "simbolo de asignacion", yytext(), yyline, yychar)); return new Symbol(sym.ASIGNACION,yyline,(int) yychar, yytext());}
"@"             {tokens.add(new Token(yytext(), "simbolo de arroba", yytext(), yyline, yychar)); return new Symbol(sym.ARROBA,yyline,(int) yychar, yytext());}
"->"            {tokens.add(new Token(yytext(), "simbolo de asignacion column", yytext(), yyline, yychar)); return new Symbol(sym.ASIGNACIONINV,yyline,(int) yychar, yytext());}
"="             {tokens.add(new Token(yytext(), "simbolo igual", yytext(), yyline, yychar)); return new Symbol(sym.IGUAL,yyline,(int) yychar, yytext());}
","             {tokens.add(new Token(yytext(), "simbolo de coma", yytext(), yyline, yychar)); return new Symbol(sym.COMA,yyline,(int) yychar, yytext());}
"["             {tokens.add(new Token(yytext(), "corchete que abre", yytext(), yyline, yychar)); return new Symbol(sym.CORAPERTURA,yyline,(int) yychar, yytext());}
"]"             {tokens.add(new Token(yytext(), "corchete que cierra", yytext(), yyline, yychar)); return new Symbol(sym.CORCIERRE,yyline,(int) yychar, yytext());}
"("             {tokens.add(new Token(yytext(), "parentesis que abre", yytext(), yyline, yychar)); return new Symbol(sym.PARAPERTURA,yyline,(int) yychar, yytext());}
")"             {tokens.add(new Token(yytext(), "parentesis que cierra", yytext(), yyline, yychar)); return new Symbol(sym.PARCIERRE,yyline,(int) yychar, yytext());}
"SUM"           {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.SUM,yyline,(int) yychar, yytext());}
"RES"           {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.RES,yyline,(int) yychar, yytext());}
"MUL"           {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.MUL,yyline,(int) yychar, yytext());}
"DIV"           {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.DIV,yyline,(int) yychar, yytext());}
"MOD"           {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.MOD,yyline,(int) yychar, yytext());}
"Media"         {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.MEDIA,yyline,(int) yychar, yytext());}
"Mediana"       {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.MEDIANA,yyline,(int) yychar, yytext());}
"Moda"          {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.MODA,yyline,(int) yychar, yytext());}
"Varianza"      {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.VARIANZA,yyline,(int) yychar, yytext());}
"Max"           {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.MAX,yyline,(int) yychar, yytext());}
"Min"           {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.MIN,yyline,(int) yychar, yytext());}
"graphPie"      {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.GRAPHPIE,yyline,(int) yychar, yytext());}
"graphBar"      {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.GRAPHBAR,yyline,(int) yychar, yytext());}
"graphLine"     {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.GRAPHLINE,yyline,(int) yychar, yytext());}
"Histogram"     {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.HISTOGRAM,yyline,(int) yychar, yytext());}
"label"         {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.LABEL,yyline,(int) yychar, yytext());}
"titulo"        {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.TITULO,yyline,(int) yychar, yytext());}
"values"        {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.VALUES,yyline,(int) yychar, yytext());}
"EXEC"          {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.EXEC,yyline,(int) yychar, yytext());}
"ejeX"          {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.EJEX,yyline,(int) yychar, yytext());}
"ejeY"          {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.EJEY,yyline,(int) yychar, yytext());}
"tituloX"       {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.TITULOX,yyline,(int) yychar, yytext());}
"tituloY"       {tokens.add(new Token(yytext(), "palabra reservada", yytext(), yyline, yychar)); return new Symbol(sym.TITULOY,yyline,(int) yychar, yytext());}


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