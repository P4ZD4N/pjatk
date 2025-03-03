function setup() {
    createCanvas(400, 400);
}

function draw() {
    for(y = 0; y < height; y++) {
        for(x = 0; x < width; x++) {
            set(x, y, color(255, 0, 255));   
        }
    }
    updatePixels();
}