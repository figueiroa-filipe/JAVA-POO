package com.codegym.task.task16.task1631;

import com.codegym.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){
        ImageReader img = null;
        if (type instanceof ImageTypes) {
            if (type.equals(ImageTypes.JPG)) img = new JpgReader();
            else if (type.equals(ImageTypes.PNG)) img = new PngReader();
            else if (type.equals(ImageTypes.BMP)) img = new BmpReader();
        } else throw new IllegalArgumentException("Unknown image type");

        return img;
    }
}
