function setup() {
    createCanvas(800, 600);
    noLoop();
}

function draw() {
    drawSky();
    drawGrass();
    drawFlowers();
    drawFacade();
    drawRoof();
    updatePixels();
}

function drawSky() {
    for(y = 0; y < height; y++) {
        for(x = 0; x < width; x++) {
            set(x, y, color(100, 200, 255));   
        }
    }
}

function drawGrass() {
    for (y = 450; y < height; y++) {
        for(x = 0; x < width; x++) {
            set(x, y, color(0, 140, 0));   
        }
    }
}

function drawFlowers() {
    for (let i = 0; i < 1000; i++) {
        let x = floor(random(0, width));
        let y = floor(random(450, height)); 
        let clr = color(random(200, 255), random(100, 255), random(100, 255));
        set(x, y, clr);
    }
}

function drawFacade() {
    for (y = 200; y < height - 150; y++) {
        for(x = 200; x < width - 200; x++) {
              set(x, y, color(139, 69, 19));   
        }
    }
}

function drawRoof() {
    let startX = width / 2;
    let inclineFactor = 2; 

    for (let y = 50; y < 210; y++) {
        let triangleWidth = floor((y - 50) * inclineFactor);
        
        for (let x = startX; x < startX + triangleWidth; x++) {
            set(x, y, color(255, 127, 80));
        }

        for (let x = startX; x > startX - triangleWidth; x--) {
            set(x, y, color(255, 127, 80));
        }
    }
}
