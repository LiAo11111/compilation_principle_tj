#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

//存储标识符以及标识符数量
#define MAX_IDENT 100
string ident_string[MAX_IDENT+1];
bool ident_type[MAX_IDENT+1];//标识符是常量还是变量，false为常量
int ident_num=0;
//查看标识符是否出现过
bool check_ident(string st)
{
	for(int i=1;i<=ident_num;i++)
		if(st==ident_string[i])
			return false;
	return true;
}
//查看标识符是否能进行赋值
bool check_ident_CorV(string st)
{
	for(int i=1;i<=ident_num;i++)
		if(st==ident_string[i])
			return ident_type;
	return false;
}
// 定义单词类型枚举
enum TokenType {
    ident, // 标识符
    number, // 数字
    keyword,// 关键字
    symbol  //符号

};
const char* type_names[] = { //定义数组
    "ident", // 标识符
    "number", // 数字
    "keyword" ,// 关键字
    "symbol"  //符号

};

// 定义符号类型枚举
enum Symbol {

    Plus, // "+"
    Minus, // "-"
    times, // "*"
    slash, // "/"
    eql, // "="
    lss, // "<"
    gtr, // ">"
    lparen, // "("
    rparen, // ")"
    comma, // ","
    semicolon, // ";"
    colon, // ":"
    period, // "."
    becomes, // ":="
    leq, // "<="
    geq, // ">="
    neq,// "#"
    error//无效字符

};
const char* symbol_names[] = {

    "Plus", // "+"
    "Minus", // "-"
    "times", // "*"
    "slash", // "/"
    "eql", // "="
    "lss", // "<"
    "gtr", // ">"
    "lparen", // "("
    "rparen", // ")"
    "comma", // ","
    "semicolon", // ";"
    "colon", // ":"
    "period", // "."
    "becomes", // ":="
    "leq", // "<="
    "geq", // ">="
    "neq" ,// "#"
    "error"//无效字符

};

// 定义单词结构体
struct Token {
    TokenType type; // 单词类型
    Symbol symSignal;//符号类型
    string value; // 单词值
};

// 定义关键字
vector<string> keywords = { "PROGRAM", "BEGIN", "END", "CONST", "VAR", "WHILE", "DO", "IF", "THEN" };

// 判断一个字符串是否是关键字
bool isKeyword(string str) {
    for (string keyword : keywords) {
        if (str == keyword) {
            return true;
        }
    }
    return false;
}

// 判断一个字符是否是有意义的符号
bool isSymbol(char c) {
    string symbols = "+-*/=<>(),.;:";
    return symbols.find(c) != string::npos;
}

// 获取下一个单词
Token getNextToken(ifstream& ifs) {
    Token token;
    char c;

    // 跳过空格和注释
    while (ifs.get(c)) {
        if (isspace(c)) {
            continue;
        }
        else if (c == '/') {
            if (ifs.get(c) && c == '*') {
                // 跳过注释
                while (ifs.get(c)) {
                    if (c == '*' && ifs.get(c) && c == '/') {
                        break;
                    }
                }
            }
            else {
                ifs.putback(c);
                break;
            }
        }
        else {
            break;
        }
    }

    // 判断标识符、关键字等类型
    if (c>='a'&&c<='z'||c>='A'&&c<='Z') {
        token.type = ident;
        token.value += c;
        while (ifs.get(c) && (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') && !ifs.eof()) {
            token.value += c;
        }
        ifs.putback(c);
        if (isKeyword(token.value)) {
            token.type = keyword;
        }
    }

    // 判断数字类型
    else if (c>='0'&&c<='9') {
        token.type = number;
        token.value += c;
        while (ifs.get(c) && c >= '0' && c <= '9') {
            token.value += c;
        }
        ifs.putback(c);
    }

    // 判断符号类型
    else if (isSymbol(c)) {
        token.type = symbol;
        token.value += c;
        switch (c) {
        case '+':  token.symSignal = Plus; token.value = '+'; break;
        case '-': token.symSignal = Minus; token.value = '-'; break;
        case '*': token.symSignal = times; token.value = '*'; break;
        case '/': token.symSignal = slash; token.value = '/'; break;
        case '=': token.symSignal = eql; token.value = '='; break;
        case '#': token.symSignal = neq; token.value = '#'; break;
        case '<': {
            if (ifs.get(c) && c == '=') {
                token.symSignal = leq;
                token.value = "<=";
            }

            else {
                ifs.putback(c);
                token.symSignal = lss;
                token.value = "<";
            }
            break;
        }
        case '>': {
            if (ifs.get(c) && c == '=') {
                token.symSignal = geq;
                token.value = ">=";
            }
            else {
                ifs.putback(c);
                token.symSignal = gtr;
                token.value = ">";
            }
            break;
        }
        case '(': token.symSignal = lparen; token.value = '('; break;
        case ')': token.symSignal = rparen; token.value = ')'; break;
        case ',': token.symSignal = comma; token.value = ','; break;
        case ';': token.symSignal = semicolon; token.value = ';'; break;
        case ':': {
            if (ifs.get(c) && c == '=') {
                token.symSignal = becomes;
                token.value = ":=";
            }
            else {
                ifs.putback(c);
                token.symSignal = colon;
                token.value = ":";
            }
            break;
        }
        case '.': token.symSignal = period; token.value = "."; break;
        }
    }

    // 无效字符处理
    else {
        token.symSignal = error;
        token.value += c;
    }

    return token;
}
void printFileContents(const std::string& filename) {  //在控制端打印输入文件数据
    std::ifstream file(filename);
    std::string line;
    while (std::getline(file, line)) {
        std::cout << "source program: " << line << std::endl;
    }
}
//语法分析器开始
ifstream ifs;
ofstream ofs;
int address=0;//四元式地址
string Intermidiate_Code[110][5];//四元式列表
void print_Intermediatecode()
{
	for(int i=1;i<=address;i++)
		ofs<<i+99<<"("<<Intermidiate_Code[i][1]<<" , "<<Intermidiate_Code[i][2]<<" , "<<Intermidiate_Code[i][3]<<" , "<<Intermidiate_Code[i][4]<<")"<<endl;
}
//函数定义
Token token;
void PROGRAM_HEAD();
void BLOCK();
void CONST_Process();
void CONST();
void VAR();
void STATE();
void EXP();
void TERM();
void FACTOR();
void CEXP();
//<程序>→<程序首部> <分程序>
void PROGRAM()
{
	PROGRAM_HEAD();
	BLOCK();
}
//<程序首部>→PROGRAM <标识符>
void PROGRAM_HEAD()
{
	token=getNextToken(ifs);
	
	if(token.type!=keyword&&token.value!="PROGRAM")
		ofs<<"Error:expected PROGRAM"<<endl;
		
	token=getNextToken(ifs);
	if(token.type!=ident)
		ofs<<"Error:expected ident"<<endl;
}
//<分程序>→[<常量说明>][<变量说明>]<语句>
void BLOCK()
{
	token=getNextToken(ifs);
	
	if(token.type==keyword&&token.value=="CONST")
		CONST_Process();
	if(token.type==keyword&&token.value=="VAR")
		VAR();
		
	STATE();
}
//<常量说明>→CONST <常量定义>
void CONST_Process()
{
	CONST();
	while((token=getNextToken(ifs)).type==symbol)
	{
		if(symbol_names[token.symSignal]=="semicolon")
		{
			token=getNextToken(ifs);
			break;
		}
		//默认为逗号，不再处理别的错误了，不然太麻烦
		else
			CONST();
	}
}
//<常量定义>→<标识符>:=<无符号整数>
void CONST()
{
	token=getNextToken(ifs);
	//如果是标识符
	if(token.type==ident)
	{
		string ident_now=token.value;//暂存该标识符
		//是否出现过
		if(!check_ident(token.value))
			ofs<<"Error:redefinition of ident "<<token.value<<endl;
		else
			ident_string[++ident_num]=token.value,ident_type[ident_num]=false;
			
		//如果接下来是:=  是其它符号，假定读取的一定是符号
		token=getNextToken(ifs);
		if(token.type==symbol&&symbol_names[token.symSignal]=="becomes")
		{
			token=getNextToken(ifs);//之后便不考虑错误了，不然太复杂了
			address++;
			Intermidiate_Code[address][1]=":=";
			Intermidiate_Code[address][2]=token.value;
			Intermidiate_Code[address][3]="-";
			Intermidiate_Code[address][4]=ident_now;
		}
		//如果是其它符号，都假定为CONST x,y:=1;这种错误，不是分号就直接越过没有赋值的常量进行下个常量读取
		else
		{
			ofs<<"Error:"<<ident_now<<"  declared as const but not initialized"<<endl;
			if(symbol_names[token.symSignal]!="semicolon")	
				CONST();
		}
	}
	//不是
	else
		ofs<<"Error:expected ident"<<endl;
}
//<变量说明>→VAR<标识符>{，<标识符>};
//这部分错误处理也仅限于VAR x,;这种多了逗号或少了逗号的情况，除逗号、分号以外的符号均视为逗号
void VAR()
{
	token=getNextToken(ifs);
	while(1)
	{
		//如果是符号
		if(token.type==symbol)
		{
			ofs<<"Error:expected ident"<<endl;
			if(symbol_names[token.symSignal]=="semicolon")
				break;
			else continue;
		}
		if(!check_ident(token.value))
			ofs<<"Error:redefinition of ident "<<token.value<<endl;
		else
			ident_string[++ident_num]=token.value,ident_type[ident_num]=true;
		//假定后面的一定会是符号，只算，和；
		token=getNextToken(ifs);
		if(token.type==symbol)
		{
			if(symbol_names[token.symSignal]=="comma")
			{
				token=getNextToken(ifs);
				continue;
			}
			else
			{
				token=getNextToken(ifs);
				break;
			}
		}
	}	
}
			
//<复合语句>→BEGIN <语句>{; <语句>} END
//<赋值语句>→<标识符>:=<表达式>
//<条件语句>→IF <条件> THEN <语句>
//<循环语句>→WHILE <条件> DO <语句>
string middle_ident;//中间变量或结果
int middle_num=-1;//中间变量数量，方便命名
void STATE()
{
	//临时四元式
	string Intermidiate_Code_now[5];
	//赋值语句
	if(token.type==ident)
	{
		//没有定义过的标识符
		string ident_now=token.value;
		if(check_ident(token.value))
			ofs<<"Error:undefinition of ident "<<token.value<<endl;
		if(!check_ident_CorV(token.value))
			ofs<<"Error:assignment of read-only variable "<<token.value<<endl;
		//假定接下来一定是:=,不是也按照:=处理
		token=getNextToken(ifs);
		//把:=读掉，再预读一位
		token=getNextToken(ifs);
		EXP();
		
		address++;
		Intermidiate_Code[address][1]=":=";
		Intermidiate_Code[address][2]=middle_ident;
		Intermidiate_Code[address][3]="-";
		Intermidiate_Code[address][4]=ident_now;
	}
	else if(token.type==keyword&&token.value=="WHILE")
	{
		int j_start=address+1;
		token=getNextToken(ifs);
		CEXP();
		if(token.type==keyword&&token.value!="DO")
			ofs<<"Error:expected DO"<<endl;
		token=getNextToken(ifs);
		//失败跳转
		int fail_address=++address;
		Intermidiate_Code[address][1]="j";
		Intermidiate_Code[address][2]="-";
		Intermidiate_Code[address][3]="-";
		STATE();
		//语句执行完跳转
		address++;
		Intermidiate_Code[address][1]="j";
		Intermidiate_Code[address][2]="-";
		Intermidiate_Code[address][3]="-";
		Intermidiate_Code[address][4]=to_string(j_start+99);
		
		Intermidiate_Code[fail_address][4]=to_string(address+100);
	}
	else if(token.type==keyword&&token.value=="IF")
	{
		token=getNextToken(ifs);
		CEXP();
		if(token.type==keyword&&token.value!="THEN")
			ofs<<"Error:expected THEN"<<endl;
		token=getNextToken(ifs);
		//失败跳转
		int fail_address=++address;
		Intermidiate_Code[address][1]="j";
		Intermidiate_Code[address][2]="-";
		Intermidiate_Code[address][3]="-";
		STATE();

		Intermidiate_Code[fail_address][4]=to_string(address+100);
	}
	//复合语句
	else if(token.type==keyword&&token.value=="BEGIN")
	{
		token=getNextToken(ifs);
		STATE();
		//语句后面一定是符号，其他情况不搞了
		while(token.type==symbol)
		{
			if(symbol_names[token.symSignal]!="semicolon")
				ofs<<"Error:expected semicolon"<<endl;
			token=getNextToken(ifs);
			STATE();
		}
		//假设出来的一定是END，其它报错后直接按END处理
		if(token.value!="END")
			ofs<<"Error:expected END"<<endl;
		token=getNextToken(ifs);
	}
	//有错误也不处理了，仅进行报错
	else
		ofs<<"Error:expected legal statement"<<endl;
}
//<表达式>→[+|-]项 | <表达式> <加法运算符> <项>
//有左循环，直接改写成  <表达式>→[+|-]项 | <项> [<加法运算符> <项>]
//后续就不进行错误处理了，太麻烦了根本想不过来
void EXP()
{
	bool Polarity=true;
	// */-处理
	if(token.type==symbol&&(symbol_names[token.symSignal]=="Plus"||symbol_names[token.symSignal]=="Minus"))
	{
		Polarity=false;
		token=getNextToken(ifs);
	}
	TERM();
	// */-处理
	if(!Polarity)
	{
		middle_num++;
		string middle_ident_new="T"+to_string(middle_num);
		address++;
		Intermidiate_Code[address][1]="NEG";
		Intermidiate_Code[address][2]=middle_ident;
		Intermidiate_Code[address][3]="-";
		Intermidiate_Code[address][4]=middle_ident_new;
		middle_ident=middle_ident_new;
	}
	while(token.type==symbol&&(symbol_names[token.symSignal]=="Plus"||symbol_names[token.symSignal]=="Minus"))
	{
		string Intermidiate_Code_now[5];
		
		if(symbol_names[token.symSignal]=="Plus")
			Intermidiate_Code_now[1]="+";
		else
			Intermidiate_Code_now[1]="-";
		Intermidiate_Code_now[2]=middle_ident;
		
		token=getNextToken(ifs);
		TERM();
		
		Intermidiate_Code_now[3]=middle_ident;
			
		middle_num++;
		string middle_ident_new="T"+to_string(middle_num);
		Intermidiate_Code_now[4]=middle_ident_new;
		middle_ident=middle_ident_new;
		
		Intermidiate_Code[++address][1]=Intermidiate_Code_now[1];
		Intermidiate_Code[address][2]=Intermidiate_Code_now[2];
		Intermidiate_Code[address][3]=Intermidiate_Code_now[3];
		Intermidiate_Code[address][4]=Intermidiate_Code_now[4];
	}
}
//<项>→<因子> | <因子>[<乘法运算符> <因子>]
void TERM()
{
	FACTOR();
	//后面的已经在FACTOR读取了，不是加减乘除就是分号
	while(token.type==symbol&&(symbol_names[token.symSignal]=="times"||symbol_names[token.symSignal]=="slash"))
	{
		string Intermidiate_Code_now[5];
		
		if(symbol_names[token.symSignal]=="times")
			Intermidiate_Code_now[1]="*";
		else
			Intermidiate_Code_now[1]="/";
		Intermidiate_Code_now[2]=middle_ident;
		
		token=getNextToken(ifs);
		FACTOR();
		
		Intermidiate_Code_now[3]=middle_ident;
			
		middle_num++;
		string middle_ident_new="T"+to_string(middle_num);
		Intermidiate_Code_now[4]=middle_ident_new;
		middle_ident=middle_ident_new;
		
		Intermidiate_Code[++address][1]=Intermidiate_Code_now[1];
		Intermidiate_Code[address][2]=Intermidiate_Code_now[2];
		Intermidiate_Code[address][3]=Intermidiate_Code_now[3];
		Intermidiate_Code[address][4]=Intermidiate_Code_now[4];
	}
}
//<因子>→<标识符> |<无符号整数> | (<表达式>)
void FACTOR()
{
	if(token.type==ident)
	{
		middle_ident=token.value;
		token=getNextToken(ifs);
	}
	else if(token.type==number)
	{
		middle_ident=token.value;
		token=getNextToken(ifs);
	}
	else if(token.type==symbol&&symbol_names[token.symSignal]=="lparen")
	{
		token=getNextToken(ifs);
		EXP();
		token=getNextToken(ifs);
		if(token.type==symbol&&symbol_names[token.symSignal]!="rparen")
			ofs<<"Error:expected rparen"<<endl;
		token=getNextToken(ifs);
	}
}
//<条件>→<表达式> <关系运算符> <表达式>
void CEXP()
{
	string Intermidiate_Code_now[5];
	string op;//运算符
	EXP();
	Intermidiate_Code_now[2]=middle_ident;
	if(token.type==symbol)
	{
		if(symbol_names[token.symSignal]=="eql")
			op="=";
		if(symbol_names[token.symSignal]=="lss")
			op="<";
		if(symbol_names[token.symSignal]=="gtr")
			op=">";
		if(symbol_names[token.symSignal]=="leq")
			op="<=";
		if(symbol_names[token.symSignal]=="geq")
			op=">=";
		token=getNextToken(ifs);
	}
	Intermidiate_Code_now[1]="j"+op;
	EXP();
	Intermidiate_Code_now[3]=middle_ident;
	address++;
	Intermidiate_Code_now[4]=to_string(address+101);
	
	Intermidiate_Code[address][1]=Intermidiate_Code_now[1];
	Intermidiate_Code[address][2]=Intermidiate_Code_now[2];
	Intermidiate_Code[address][3]=Intermidiate_Code_now[3];
	Intermidiate_Code[address][4]=Intermidiate_Code_now[4];
}
int main()
{
	ifs.open("input.txt");
    ofs.open("output.txt");
    PROGRAM();
    /*
    Token token;
    while ((token = getNextToken(ifs)).type != symbol || token.value != ".")
    {
        if (token.type == keyword)
        {
            ofs << "(" << token.value << ")" << endl;
        }
        else if (token.type == symbol) {
            ofs << "(" << symbol_names[token.symSignal] << ", " << token.value << ")" << endl;
        }
        else {
            ofs << "(" << type_names[token.type] << ", " << token.value << ")" << endl;
        }
    }
    ofs << "(" << symbol_names[token.symSignal] << ", " << token.value << ")" << endl;
    */
    print_Intermediatecode();
    ifs.close();
    ofs.close();
    return 0;
}
