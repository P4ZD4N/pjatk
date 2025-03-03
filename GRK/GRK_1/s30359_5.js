function setup() {
    createCanvas(800, 600);
}

function draw() {
    for(y = 0; y < height; y++) {
        for(x = 0; x < width; x++) {
            set(x, y, color(100, 200, 255));   
        }
    }
  
    for (y = 400; y < height; y++) {
        for(x = 0; x < width; x++) {
                set(x, y, color(20, 255, 20));   
        }
    }
    updatePixels();
}

// https://editor.p5js.org/