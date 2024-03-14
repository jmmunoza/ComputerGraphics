package components.canvas.components.neighborhood;

import components.canvas.components.house3d.House3D;
import components.canvas.shapes.ShapeComposite;
import components.canvas.transformations.translation.Translation3D;

import java.io.FileNotFoundException;

public class Neighborhood extends ShapeComposite {
    private final String housePath;

    public Neighborhood(String housePath, int nHouses) throws FileNotFoundException {
        this.housePath = housePath;

        add(generateNeighborhood(nHouses));
    }

    public ShapeComposite generateNeighborhood(int n) throws FileNotFoundException {
        ShapeComposite neighborHood = new ShapeComposite();

        int centerX = n / 2;
        int centerZ = n / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ShapeComposite house = new House3D(housePath);
                int offsetX = (i - centerX) * 700;
                int offsetZ = (j - centerZ) * 700;
                house.transform(new Translation3D(offsetX, 0, offsetZ));
                neighborHood.add(house);
            }
        }

        return neighborHood;
    }
}
