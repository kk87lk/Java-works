public class CompositePatternDemo {

    public static void main(String[] args) {
        FarmUnit Composition = new FarmUnit("John", "Composition", 30);
        FarmUnit meat = new FarmUnit("Beef", "Meat", 20);
        FarmUnit vege = new FarmUnit("Onion", "vege", 12);
        FarmUnit vege1 = new FarmUnit("Potato", "Vegetable", 5);
        FarmUnit vege2 = new FarmUnit("Carrot", "Vegetable", 8);
        FarmUnit meat1 = new FarmUnit("Chicken", "Meat", 15);
        FarmUnit meat2 = new FarmUnit("Pork", "Meat", 30);
        Composition.add(meat);
        Composition.add(vege);
        meat.add(meat1);
        meat.add(meat2);
        vege.add(vege1);
        vege.add(vege2);
        System.out.println(Composition);
        for (FarmUnit FarmUnits : Composition.getSubordinates()) {
            System.out.println(FarmUnits);
            for (FarmUnit FarmUnit : FarmUnits.getSubordinates()) {
                System.out.println(FarmUnit);
            }
        }
    }
}