package oop.interfaces;

import extras.Decoration;

public interface BasicDecoration {
	public Decoration getNormalDecoration();
	public void setNormalDecoration(Decoration normal);
	public Decoration getHoveredDecoration();
	public void setHoveredDecoration(Decoration hovered);
	public Decoration getPressedDecoration();
	public void setPressedDecoration(Decoration pressed);
}
