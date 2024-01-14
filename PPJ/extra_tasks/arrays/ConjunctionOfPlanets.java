public class ConjunctionOfPlanets {
    private String[] planets1;
    private String[] planets2;

    public ConjunctionOfPlanets(String[] planets1, String[] planets2) {
        this.planets1 = planets1;
        this.planets2 = planets2;
    }

    public String[] getPlanets1() {
        return planets1;
    }

    public String[] getPlanets2() {
        return planets2;
    }

    public String[] getMergedPlanetsWithoutDuplicates() {
        String[] mergedPlanetsWithoutDuplicatesTemp = new String[planets1.length + planets2.length];

        if (planets1.length + planets2.length > 0) {

            int distinctPlanets = 0;
            int duplicates = 0;
            for (int i = 0; i < planets1.length; i++) {
                for (String mergedPlanetsWithoutDuplicate : mergedPlanetsWithoutDuplicatesTemp)
                    if (planets1[i].equals(mergedPlanetsWithoutDuplicate))
                        duplicates++;
                if (duplicates == 0) {
                    mergedPlanetsWithoutDuplicatesTemp[i] = planets1[i];
                    distinctPlanets++;
                }
                duplicates = 0;
            }

            for (int i = planets1.length, index = 0; i < mergedPlanetsWithoutDuplicatesTemp.length; i++, index++) {
                for (int j = 0; j < mergedPlanetsWithoutDuplicatesTemp.length; j++)
                    if (planets2[index].equals(mergedPlanetsWithoutDuplicatesTemp[j]))
                        duplicates++;
                if (duplicates == 0) {
                    mergedPlanetsWithoutDuplicatesTemp[i] = planets2[index];
                    distinctPlanets++;
                }
                duplicates = 0;
            }

            String[] mergedPlanetsWithoutDuplicates = new String[distinctPlanets];

            int index = 0;
            for (String planet : mergedPlanetsWithoutDuplicatesTemp) {
                if (planet != null)
                    mergedPlanetsWithoutDuplicates[index++] = planet;
            }

            return mergedPlanetsWithoutDuplicates;

        } else throw new IllegalArgumentException("Give me more planets!");
    }

    private void fillArrayWithDistinctPlanetFromFirstArray() {

    }
}
