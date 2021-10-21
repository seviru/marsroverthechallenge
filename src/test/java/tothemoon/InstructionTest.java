package tothemoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class InstructionTest {

    @Test
    void shouldParseList() {
        String instructionsRaw = "LMRLMR";
        List<Instruction> expected = new ArrayList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);

        List<Instruction> actual = Instruction.parseInstructions(instructionsRaw);

        Assertions.assertEquals(expected, actual);
    }
}
