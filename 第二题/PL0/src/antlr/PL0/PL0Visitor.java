// Generated from C:/Users/86188/Desktop/PL0/PL0/src/antlr/PL0.g4 by ANTLR 4.13.1
package antlr.PL0;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PL0Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PL0Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PL0Parser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(PL0Parser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PL0Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#program_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_header(PL0Parser.Program_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#program_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_start(PL0Parser.Program_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#const}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst(PL0Parser.ConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#const_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_def(PL0Parser.Const_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#unsigned_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsigned_int(PL0Parser.Unsigned_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(PL0Parser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(PL0Parser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#complex_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplex_state(PL0Parser.Complex_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(PL0Parser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#assignment_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_state(PL0Parser.Assignment_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PL0Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(PL0Parser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(PL0Parser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(PL0Parser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(PL0Parser.MulContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#if_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_state(PL0Parser.If_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#loop_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_state(PL0Parser.Loop_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PL0Parser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(PL0Parser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#empty_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_state(PL0Parser.Empty_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(PL0Parser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link PL0Parser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(PL0Parser.NumContext ctx);
}