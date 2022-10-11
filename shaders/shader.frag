#version 330

in vec2 wc_pos_out;

void main() {
    int m = int(wc_pos_out.x*512);
    int n = int(wc_pos_out.y*512);
    if ((m&n) == 0) {
        gl_FragColor = vec4(1, 1, 1, 1);
    } else {
        gl_FragColor = vec4(0, 0, 0, 1);
    }
}
