class MergeCalculator {

    int[] getTargetPopByGen(int specifiedGen, int royalPop, int[] currentPopByGen) {
        int[] targetPopByGen = new int[specifiedGen];

        for(int i = 0; i < targetPopByGen.length; ++i) {
            if (i == 0) {
                targetPopByGen[i] = royalPop - currentPopByGen[i];
            } else {
                targetPopByGen[i] = getTotalParentsNeeded();
            }
        }

        return targetPopByGen;
    }

    private int getTotalParentsNeeded () {
        return 10;
    }
}
