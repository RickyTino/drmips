/*
    DrMIPS - Educational MIPS simulator
    Copyright (C) 2013-2014 Bruno Nova <ei08109@fe.up.pt>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.feup.brunonova.drmips.simulator.mips.components;

import java.util.ArrayList;
import java.util.List;
import org.feup.brunonova.drmips.simulator.exceptions.InvalidCPUException;
import org.feup.brunonova.drmips.simulator.mips.AssembledInstruction;
import org.feup.brunonova.drmips.simulator.mips.Component;
import org.feup.brunonova.drmips.simulator.mips.Data;
import org.feup.brunonova.drmips.simulator.mips.Input;
import org.feup.brunonova.drmips.simulator.mips.Output;
import org.feup.brunonova.drmips.simulator.util.Dimension;
import org.feup.brunonova.drmips.simulator.util.Point;

/**
 * Class that represents the instruction memory.
 * 
 * @author Bruno Nova
 */
public class InstructionMemory extends Component {
	private final Input input;
	private final Output output;
	private List<AssembledInstruction> instructions;

	/**
	 * Instruction memory constructor.
	 * @param id Instruction memory's identifier.
	 * @param latency The latency of the component.
	 * @param position The component's position on the GUI.
	 * @param inId The identifier of the input.
	 * @param outId The identifier of the output.
	 * @throws InvalidCPUException If <tt>id</tt> is empty or duplicated.
	 */
	public InstructionMemory(String id, int latency, Point position, String inId, String outId) throws InvalidCPUException {
		super(id, latency, "Instruction\nMemory", "instruction_memory", "instruction_memory_description", position, new Dimension(80, 100));
		instructions = new ArrayList<AssembledInstruction>();
		input = addInput(inId, new Data());
		output = addOutput(outId, new Data());
	}

	@Override
	public void execute() {
		int index = getInput().getValue() / (Data.DATA_SIZE / 8);
		if(index >= 0 && index < instructions.size())
			getOutput().setValue(getInstruction(index).getData().getValue());
		else
			getOutput().setValue(0);
	}
	
	/**
	 * Returns the assembled instruction with the specified index.
	 * @param index Index of the instruction.
	 * @return The desired instruction, or <tt>null</tt> if it doesn't exist.
	 */
	public final AssembledInstruction getInstruction(int index) {
		if(index >= 0 && index < instructions.size())
			return instructions.get(index);
		else
			return null;
	}
	
	/**
	 * Returns the number of instructions in memory.
	 * @return The number of instructions.
	 */
	public final int getNumberOfInstructions() {
		return instructions.size();
	}
	
	/**
	 * Loads the specified instructions into the memory.
	 * @param instructions Instructions to load.
	 */
	public final void setInstructions(List<AssembledInstruction> instructions) {
		this.instructions = instructions;
		execute();
	}
	
	/**
	 * Return the memory's input.
	 * @return Memory input.
	 */
	public final Input getInput() {
		return input;
	}
	
	/**
	 * Return the memory's output.
	 * @return Memory output.
	 */
	public final Output getOutput() {
		return output;
	}
}