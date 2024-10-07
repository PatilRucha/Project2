package src;

public class ExprEvaluator implements ExprVisitor<Float> {
    
    @Override
    public Float visitPlusExpr(PlusExpr expr) {
        Float leftValue = expr.getE1().accept(this);
        Float rightValue = expr.getE2().accept(this);
        return calculateSum(leftValue, rightValue);
    }

    @Override
    public Float visitMinusExpr(MinusExpr expr) {
        Float leftValue = expr.getE1().accept(this);
        Float rightValue = expr.getE2().accept(this);
        return calculateDifference(leftValue, rightValue);
    }

    @Override
    public Float visitTimesExpr(TimesExpr expr) {
        Float leftValue = expr.getE1().accept(this);
        Float rightValue = expr.getE2().accept(this);
        return calculateProduct(leftValue, rightValue);
    }

    @Override
    public Float visitDivExpr(DivExpr expr) {
        Float numerator = expr.getE1().accept(this);
        Float denominator = expr.getE2().accept(this);
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return calculateQuotient(numerator, denominator);
    }

    @Override
    public Float visitFloatExpr(FloatExpr expr) {
        return expr.eval();
    }

    // Helper methods to perform calculations
    private Float calculateSum(Float a, Float b) {
        return a + b;
    }

    private Float calculateDifference(Float a, Float b) {
        return a - b;
    }

    private Float calculateProduct(Float a, Float b) {
        return a * b;
    }

    private Float calculateQuotient(Float a, Float b) {
        return a / b;
    }
}
