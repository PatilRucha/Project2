package src;

abstract class Expr {
    /*
     *  Part 1: implement the eval function for all
     *  non-abstract subclasses of Expr
     */
    abstract float eval();

    /*
     * Part 2: implement the visitor pattern for expressions
     */
    abstract <R> R accept(ExprVisitor<R> v);
}

abstract class BinaryExpr extends Expr {
    private Expr e1;
    private Expr e2;

    protected BinaryExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Expr getE1() {
        return e1;
    }

    public Expr getE2() {
        return e2;
    }
}

class PlusExpr extends BinaryExpr {
    public PlusExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }
}

class MinusExpr extends BinaryExpr {
    public MinusExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }
}

class TimesExpr extends BinaryExpr {
    public TimesExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }
}

class DivExpr extends BinaryExpr {
    public DivExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }
}

class FloatExpr extends Expr {
    protected float literal;

    public FloatExpr(float f) {
        this.literal = f;
    }
}