let point1 = { x: 400, y: 100 };
let point2 = { x: 200, y: 500 };
let point3 = { x: 600, y: 500 };

function setup() {
    createCanvas(800, 600);
    noLoop();
}

function draw() {
    background(0);
    stroke(255);
  
    point(point1.x, point1.y);
    point(point2.x, point2.y);
    point(point3.x, point3.y);
  
    let cx = point1.x;
    let cy = point1.y;
  
    for (let i = 0; i < 30000; i++) {
      let randomNumber = floor(random(0, 3));
      
        switch (randomNumber) {
          case 0:
              cx = (cx + point1.x) / 2;
              cy = (cy + point1.y) / 2;
              point(cx, cy);
              break;
          case 1:
              cx = (cx + point2.x) / 2;
              cy = (cy + point2.y) / 2;
              point(cx, cy);
              break;
          default:
              cx = (cx + point3.x) / 2;
              cy = (cy + point3.y) / 2;
              point(cx, cy);
        }
    }
}

