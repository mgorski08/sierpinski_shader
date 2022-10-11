#version 330

layout (location = 0) in vec2 pos;
layout (location = 1) in vec2 wc_pos;

out vec2 wc_pos_out;

void main() {
    gl_Position = vec4(pos, 0, 1);
    wc_pos_out = wc_pos;
}
