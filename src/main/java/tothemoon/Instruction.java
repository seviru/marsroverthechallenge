package tothemoon;

import java.util.List;
import java.util.stream.Collectors;

public enum Instruction {
    M, L, R;

    public static List<Instruction> parseInstructions(String instructionsListAsString) {
        return instructionsListAsString
                .chars()
                .boxed()
                .map(Instruction::mapToInstruction)
                .collect(Collectors.toList());
    }

    private static Instruction mapToInstruction(int charAsInt) {
        return Instruction.valueOf(String.valueOf(((char) charAsInt)));
    }
}
