class MergeCalculator {
    private int numChildrenPerLgMerge;
    private int numParentPerLgMerge;

    public MergeCalculator() {
        numChildrenPerLgMerge = 3;
        numParentPerLgMerge = 10;
    }

    int[] getTargetPopByGen(int specifiedGen, int royalPop, int[] currentPopByGen) {
        int[] targetPopByGen = new int[specifiedGen];

        for(int i = 0; i < targetPopByGen.length; ++i) {
            if (i == 0) {
                targetPopByGen[i] = royalPop - currentPopByGen[i];
            } else {
                targetPopByGen[i] = getTotalParentsNeeded(targetPopByGen[i-1]);
            }
        }

        return targetPopByGen;
    }

    private int getTotalParentsNeeded (int childrenNeeded) {
        int totalParentsNeeded = 0;

        totalParentsNeeded += getTotalParentsNeededForLgMerges(childrenNeeded);
        childrenNeeded = childrenNeeded % numChildrenPerLgMerge;

        return totalParentsNeeded;
    }

    private int getTotalParentsNeededForLgMerges(int childrenNeeded) {
        return (childrenNeeded / numChildrenPerLgMerge) * numParentPerLgMerge;
    }
}
