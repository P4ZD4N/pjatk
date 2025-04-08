function setup() {
    createCanvas(512,512);
    background(255);

}
  
let x0 = -1;
let y0 = -1;
let x1 = -1;
let y1 = -1;
  
function draw() {

}
  
function mousePressed() {
    x0 = mouseX;
    y0 = mouseY;
}
  
function mouseDragged() {  
    x1 = mouseX;
    y1 = mouseY;  

    background(255);
    noStroke();
    fill('red');
    ellipse(x0 - 3, y0 - 3,6);
    fill('green');  
    ellipse(x1 - 3, y1 - 3,6);
}
  
function mouseReleased() {
    background(255);
    loadPixels();
    draw_line();
    updatePixels();
}
  
function set_pixel(x, y, c) {
    idx = (y * 512 + x) * 4;
    pixels[idx] = c;
    pixels[idx+1] = c;
    pixels[idx+2] = c;
    pixels[idx+3] = 255;
}
  
function draw_line() {  

    let xStart = Math.round(x0);
    let yStart = Math.round(y0);
    let xEnd = Math.round(x1);
    let yEnd = Math.round(y1);
  
    let dx = xEnd - xStart;
    let dy = yEnd - yStart;
  
    let dp = 2 * dy - dx;
    let deq = 2 * dy;
    let dinc = 2 * dy - 2 * dx;
  
    let d = dp;
    let y = yStart;

    for (let x = xStart; x <= xEnd; x++) {
        set_pixel(x, y, 0);
      
        if (d < 0) {
            d += deq;
        } else {
            d += dinc;
            y++;
        }
    }
}