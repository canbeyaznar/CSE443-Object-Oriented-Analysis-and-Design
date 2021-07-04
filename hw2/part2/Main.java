/**
 * @author Can Beyaznar
 */

public class Main {

    public static void main(String[] args) {

        int a[][] = { { 1, 2, 3, 4},
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                {13, 14, 15, 16}};
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("User input:");
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }

        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("Clockwise iterator output: ");
        ClockwiseIterator x = new ClockwiseIterator(a);
        SatelliteData satelliteData = new SatelliteData(a);
        myIterator clockwiseIterator = satelliteData.createIterator();
        while (clockwiseIterator.hasNext())
        {
            int temp = (Integer) clockwiseIterator.next();
            System.out.print(temp + " ");
        }
        System.out.println("\n-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
    }

}
