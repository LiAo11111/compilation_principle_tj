# compilation_principle_tj
question1
这是第一题，一个小语言PL/0的简单编译器，包含词法分析器、语法分析器、中间代码生成。
输出四元式.
question2
掌握现代工具进行编译器二次开发
使用的是ANTLR
这是一种包含词法分析、语法分析、中间代码生成、优化、目标代码生成的编译器生成工具。

词法规则
关键字：PROGRAM、BEGIN、END、CONST、VAR、WHILE、DO、IF、THEN。
标识符：以字⺟开头的、由字⺟和数字组成的字符串。
整数：数字开头的数字串。
算符、界符：+、-、*、/、:=、=、<>、>、>=、<、<=、（、）、；、，

语法规则
<程序>→<程序⾸部> <分程序>
<程序⾸部>→PROGRAM <标识符>
<分程序>→[<常量说明>][<变量说明>]<语句>（注：[ ]中的项表⽰可选）
<常量说明>→CONST <常量定义>{，<常量定义>} ; （注： { }中的项表⽰可重复若⼲次）
<常量定义>→<标识符>:=<⽆符号整数>
<⽆符号整数>→<数字>{<数字>}
<变量说明>→VAR<标识符>{，<标识符>};
<标识符>→<字⺟>{<字⺟> | <数字>}
<复合语句>→BEGIN <语句>{; <语句>} END
<语句>→<赋值语句> | <条件语句 >| <循环语句> | <复合语句> | <空语句>
<赋值语句>→<标识符>:=<表达式>
<表达式>→[+|-]项 | <表达式> <加法运算符> <项>
<项>→<因⼦> | <项><乘法运算符> <因⼦>
<因⼦>→<标识符> |<⽆符号整数> | (<表达式>)
<加法运算符>→ + | -
<乘法运算符>→ * | /
<条件语句>→IF <条件> THEN <语句>
<循环语句>→WHILE <条件> DO <语句>
<条件>→<表达式> <关系运算符> <表达式>
<关系运算符>→ = | <> | < | <= | > | >=
<字⺟>→a | b …| x | y | z
<数字>→0 | 1 | … | 8| 9

PL/0 源程序⽰例：
PROGRAM add
VAR x,y;
BEGIN
x:=1;
y:=2;
WHILE x<5 DO x:=x+1;
IF y>0 THEN y:=y-1;
y:=y+x
END