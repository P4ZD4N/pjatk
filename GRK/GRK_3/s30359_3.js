function setup() {
    createCanvas(512, 512);
    background(255);
}
  
let x0 = -1;
let y0 = -1;
let x1 = -1;
let y1 = -1;
  
function draw() {
    let dx = x1 - x0;
    let dy = y1 - y0;
    let a = dy / dx;
    let b = y0 - a * x0;
    let twoDx = 2 * dx;

    for (let x = 0; x < width; x++) {
        for (let y = 0; y < height; y++) {

        let Dxy = (dy/dx) * (x - x0) - (y - y0);
        let Dxydash = Dxy * twoDx;
        
        if (Dxydash > 0)
            set_pixel(x, y, 0, Math.min(Dxydash, 255), 0);
        else if (Dxydash < 0) 
            set_pixel(x, y, Math.min(-Dxydash, 255), 0, 0);
        else 
            set_pixel(x, y, 0, 0, 0);
        }
    }
}
  
function mousePressed() {
    x0 = mouseX;
    y0 = mouseY;
}
  
function mouseDragged() {  
    x1 = mouseX;
    y1 = mouseY;  

    noStroke();
    fill('red');
    ellipse(x0 - 3, y0 - 3, 6);
    fill('green');  
    ellipse(x1 - 3, y1 - 3, 6);
}
  
function mouseReleased() {
    background(255);
    loadPixels();
    draw();  
    updatePixels();
}

  
function set_pixel(x, y, r, g, b) {
    if (x >= 0 && x < width && y >= 0 && y < height) {
        let idx = (y * 512 + x) * 4;
        pixels[idx] = r; 
        pixels[idx + 1] = g; 
        pixels[idx + 2] = b; 
        pixels[idx + 3] = 255;
    }
}
  