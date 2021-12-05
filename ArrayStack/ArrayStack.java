package ArrayStack;

import javax.management.RuntimeErrorException;

public class ArrayStack 
{
	private int top = -1;
	private final Object[] stack;
	
	public ArrayStack(int stackSize)
	{
		this.stack = new Object[stackSize];
	}
	
	public boolean isEmpty()
	{
		return -1 == top;
	}
	
	public boolean isFull()
	{
		return stack.length-1 == top;
	}
	
	public void push(Object data)
	{
		if(isFull())
		{
			throw new RuntimeException("stack is full");
		}
		stack[++top] = data;
	}
	
	public Object pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("stack is empty");
		}
		Object tempData = stack[top];
		stack[top--] = null;
		return tempData;
	}
	
	public Object peek()
	{
		if(isEmpty())
		{
			return null;
		}
		return stack[top];
	}
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		if(isEmpty())
		{
			return "Empty Stack";
		}
		stringBuilder.append("bottom").append("|");
		for(int i=0; i<=top; i++)
		{
			stringBuilder.append(stack[i]).append("|");
		}
		stringBuilder.append("top").append("|");
		return stringBuilder.toString();
	}
}
