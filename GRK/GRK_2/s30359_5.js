function preload() {
    img = loadImage("https://raw.githubusercontent.com/scikit-image/scikit-image/master/skimage/data/astronaut.png");
  }

function setup() {
    createCanvas(4096, 4096);
    img.filter('gray');

    let histogram = new Array(256).fill(0);

    img.loadPixels();

    for(x = 0; x < img.width; x++)
        for(y = 0; y < img.height; y++) {      
            let pos = 4 * (y * img.width + x);
            let r = img.pixels[pos];
            histogram[r]++;
        }

    background(255);

    for (let i = 0; i < histogram.length; i++) {
        let barHeight = map(histogram[i], 0, max(histogram), 0, height);
        stroke(0);
        line(i, height, i, height - barHeight);
    }
}