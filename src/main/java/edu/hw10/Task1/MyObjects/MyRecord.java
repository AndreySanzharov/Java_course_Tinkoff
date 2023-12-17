package edu.hw10.Task1.MyObjects;

import edu.hw10.Task1.Annotatons.Max;
import edu.hw10.Task1.Annotatons.Min;
import edu.hw10.Task1.Annotatons.NotNull;


public record MyRecord(@Min(2.0) float value1, @Min('f') @Max('r') char value2, @NotNull Integer value3) {
}
