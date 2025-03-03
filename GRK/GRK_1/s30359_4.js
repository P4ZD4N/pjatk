function setup() {
    createCanvas(800, 600);
}

function draw() {
    for(y = 0; y < height; y++) {
        for(x = 0; x < width; x++) {
            let blue = (x + y) / (width + height) * 256;
            let dx = x - width / 2;
            let dy = y - height / 2;
            let d = sqrt(dx*dx+dy*dy)
            
            set(x, y, color(255 - d, 0 + d, blue));   
        }
    }
    updatePixels();
}