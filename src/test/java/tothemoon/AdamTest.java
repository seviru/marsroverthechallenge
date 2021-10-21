package tothemoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static tothemoon.AdamParser.parseAdam;

public class AdamTest {

    @Test
    public void moveToRight() {
        List<Instruction> instructionList = new ArrayList<>();
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);

        Adam adam = parseAdam(0.0, 0.0, "N", 5.0, 5.0);
        adam.executeRoute(instructionList);

        Adam expected = parseAdam(0.0, 0.0, "W", 5.0, 5.0);
        Assertions.assertEquals(expected, adam);
    }

    @Test
    public void moveToLeft() {
        List<Instruction> instructionList = new ArrayList<>();
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);

        Adam adam = parseAdam(0.0, 0.0, "N", 5.0, 5.0);
        adam.executeRoute(instructionList);

        Adam expected = parseAdam(0.0, 0.0, "E", 5.0, 5.0);
        Assertions.assertEquals(expected, adam);
    }

    @Test
    public void moveForward(){
        List<Instruction> instructionList = new ArrayList<>();
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);

        Adam adam = parseAdam(0.0, 0.0, "N", 5.0, 5.0);
        adam.executeRoute(instructionList);

        Adam expected = parseAdam(0.0, 3.0, "N", 5.0, 5.0);
        Assertions.assertEquals(expected, adam);
    }
}
