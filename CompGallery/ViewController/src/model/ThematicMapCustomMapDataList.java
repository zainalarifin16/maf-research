package model;

import java.util.ArrayList;

public class ThematicMapCustomMapDataList {
   
    private ProductHighlights[] _productHighlights = null;

    public ThematicMapCustomMapDataList() {
        super();
    }


    public ProductHighlights[] getProductHighlights() {
        if (_productHighlights == null) {
            // product detail
            ArrayList<ProductHighlights> highlightData = new ArrayList<ProductHighlights>();

            highlightData.add((new ProductHighlights("Seat", "Saddle", 1, "Seat description", "AR278", 35)));
            highlightData.add((new ProductHighlights("Body", "Frame", 2, "Body description", "AR256", 200)));
            highlightData.add((new ProductHighlights("Handle", "Handle Bar", 3, "Handle description", "AR155", 50)));
            highlightData.add((new ProductHighlights("Tire", "Tires", 4, "Tire description", "AR326", 40)));
            highlightData.add((new ProductHighlights("Gears", "Gears", 5, "Gears description", "AR252", 70)));

            _productHighlights =
                    (ProductHighlights[])highlightData.toArray(new ProductHighlights[highlightData.size()]);
        }

        return _productHighlights;
    }

    public void setProductHighlights(ProductHighlights[] ph) {
        this._productHighlights = ph;
    }
}
