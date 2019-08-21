class MergeCalculator {
    private int numChildrenPerLgMerge;
    private int numParentPerLgMerge;
    private int numChildrenPerSmMerge;
    private int numParentPerSmMerge;

    MergeCalculator() {
        numChildrenPerLgMerge = 3;
        numParentPerLgMerge = 10;
        numChildrenPerSmMerge = 1;
        numParentPerSmMerge = 4;
    }

    MergeCalculator(int numChildrenPerLgMerge, int numParentPerLgMerge, int numChildrenPerSmMerge, int numParentPerSmMerge) {
        this.numChildrenPerLgMerge = numChildrenPerLgMerge;
        this.numParentPerLgMerge = numParentPerLgMerge;
        this.numChildrenPerSmMerge = numChildrenPerSmMerge;
        this.numParentPerSmMerge = numParentPerSmMerge;
    }

    int[] getTargetPopByGen(int specifiedGen, int royalPop, int[] currentPopByGen) {
        int[] targetPopByGen = new int[specifiedGen];

        for(int i = 0; i < targetPopByGen.length; ++i) {
            if (i == 0) {
                targetPopByGen[i] = royalPop - currentPopByGen[i];
            } else {
                targetPopByGen[i] = getTotalParentsNeeded(targetPopByGen[i-1]) - currentPopByGen[i];
            }
        }

        return targetPopByGen;
    }

    int[] getTargetPopByGen(int specifiedGen, int royalPop) {
        int[] targetPopByGen = new int[specifiedGen];

        for(int i = 0; i < targetPopByGen.length; ++i) {
            if (i == 0) {
                targetPopByGen[i] = royalPop;
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

        totalParentsNeeded += getTotalParentsNeededForSmMerges(childrenNeeded);
        childrenNeeded = childrenNeeded % numChildrenPerSmMerge;

        if(childrenNeeded > 0) {
            totalParentsNeeded += numParentPerSmMerge;
        }

        return totalParentsNeeded;
    }

    private int getTotalParentsNeededForLgMerges(int childrenNeeded) {
        return (childrenNeeded / numChildrenPerLgMerge) * numParentPerLgMerge;
    }

    private int getTotalParentsNeededForSmMerges(int childrenNeeded) {
        return (childrenNeeded / numChildrenPerSmMerge) * numParentPerSmMerge;
    }
}
