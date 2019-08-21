class MergeCalculator {

    int[] getTargetPopByGen(int specifiedGen, int royalPop, int[] currentPopByGen) {
        int[] targetPopByGen = new int[specifiedGen];

        targetPopByGen[0] = royalPop - currentPopByGen[0];

        return targetPopByGen;
    }
}
