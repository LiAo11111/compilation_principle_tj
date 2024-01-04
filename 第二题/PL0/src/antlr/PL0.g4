grammar PL0;

start : program EOF;

program : program_header program_start;
program_header: 'PROGRAM' id;
program_start : const?var?state;

const: 'CONST' const_def(','const_def)*';';
const_def: id ':=' unsigned_int;
unsigned_int:num(num)*;

var: 'VAR' id(','id)*';';
id:word(word|num)*;

complex_state:'BEGIN'state(';'state)*'END';
state:assignment_state | if_state | loop_state | complex_state | empty_state;

assignment_state:id':='expression;
expression:('+'|'-')?item|expression add item;
item:factor|item mul factor;
factor:id|unsigned_int|'('expression')';
add:'+'|'-';
mul:'*'|'/';

if_state:'IF' condition 'THEN' state;

loop_state:'WHILE' condition 'DO' state;
condition:expression relation expression;
relation:'='|'<>'|'<'|'>'|'<='|'>=';
empty_state:;

word:WORD;
num:NUMBER;

NUMBER   : [0-9] ;
WORD    : [a-z];
WS : [ \t\r\n]+ -> skip;
OPERATOR : '+' | '-' | '*' | '/' | ':=' | '=' | '<' | '>' | '<=' | '>=' | '<>' | '(' | ')' | ',' | ';' ;
KEYWORD  : 'PROGRAM' | 'BEGIN' | 'END' | 'CONST' | 'VAR' | 'WHILE' | 'DO' | 'IF' | 'THEN' ;

