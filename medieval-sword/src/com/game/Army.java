package com.game;

import java.util.ArrayList;


/**
 * Army is a group of stacks.
 * Army can be associated to an hero.
 */
public class Army {

	final int N_STACKS = 5;

	final int RIGHT_SIDE = 1;
	final int LEFT_SIDE = 2;

	ArrayList<Stack> stacks;

	int battle_side;
	int selected_stack;


	public Army() {
		stacks = new ArrayList<Stack>( N_STACKS );
	}

	/**
	 * Add stack to last position of army
	 */
	public void addStack( Stack stack ){
		if( stacks.size() < N_STACKS ) {
			stacks.add( stack );
		}
	}

	public void swapStacksPosition( int a, int b ) {
		Stack aux = stacks.get( a );

		stacks.set( a, stacks.get( b ) );
		stacks.set( b, aux );
	}

	/* BATTLE FUNCTIONS */

	public void selectNexStack() {
		selected_stack++;

		if( selected_stack >= stacks.size() )
			selected_stack = 0;
	}

	public Stack getSelectedStack() {
		return stacks.get( selected_stack );
	}

	public void selectLastStack() {
		selected_stack = N_STACKS - 1;
	}

	public void selectFirstStack() {
		selected_stack = 0;
	}

	public void deleteStack( Stack stack ) {
		stacks.remove( stack );
	}

	public void update( float current_time ) {
		for( Stack stack : stacks ) {
			stack.updateActions( current_time );
		}
	}

	public ArrayList<Stack> getStacks() {
		return stacks;
	}

	public int getBattleSide() {
		return battle_side;
	}

	/**
	 * Set army battle side ( right / left ).
	 * Then set stacks side and his frame.
	 */
	public void setBattleSide( int side ) {
		this.battle_side = side;

		for( Stack stack : stacks) {
			stack.setBattleSide( side );
			stack.setFrameSide();
		}
	}

	public int getAmount() {
		int amount = 0;

		for( Stack stack : stacks )
			amount += stack.getNumber();

		return amount;
	}
}
