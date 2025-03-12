package visitor;

import visitor.shape.Circle;
import visitor.shape.CompoundShape;
import visitor.shape.Dot;
import visitor.shape.Rectangle;
import visitor.shape.Shape;

public interface Visitor
{
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
    String visitShape(Shape shape);
}
