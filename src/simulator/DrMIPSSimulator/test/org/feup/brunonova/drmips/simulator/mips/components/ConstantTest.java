/*
    DrMIPS - Educational MIPS simulator
    Copyright (C) 2013-2015 Bruno Nova <brunomb.nova@gmail.com>

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

import org.feup.brunonova.drmips.simulator.exceptions.InvalidCPUException;
import org.feup.brunonova.drmips.simulator.mips.Data;
import org.feup.brunonova.drmips.simulator.util.Point;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConstantTest {
	@Test
	public void testComponent() throws InvalidCPUException {
		tComp(0, 1);
		tComp(1, 1);
		tComp(0xffff, 16);
		tComp(0xffffffff, 32);
	}

	private void tComp(int inValue, int inSize) throws InvalidCPUException {
		Constant c = new Constant("test", 0, new Point(0, 0), "out", inValue, inSize);
		c.execute();
		assertEquals(new Data(inSize, inValue), c.getOutput().getData());
	}
}