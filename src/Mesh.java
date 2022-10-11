import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

public class Mesh {
    private final FloatBuffer vertices = BufferUtils.createFloatBuffer(1024 * 1024);
    private final FloatBuffer colors = BufferUtils.createFloatBuffer(1024*1024);
    private final IntBuffer indices = BufferUtils.createIntBuffer(1024*1024);

    int trigCount = 0;

    public int getTrigCount() {
        return trigCount;
    }

    public void addTriangle(Triangle triangle) {
        vertices.put(triangle.getCoordArray());
        colors.put(triangle.getColorArray());
        int size = indices.position();
        IntBuffer trigIndices = triangle.getIndices();
        while (trigIndices.hasRemaining()) {
            indices.put(trigIndices.get()+size);
        }
        ++trigCount;
    }

    public FloatBuffer getVertices() {
        return vertices;
    }

    public FloatBuffer getColors() {
        return colors;
    }

    public IntBuffer getIndices() {
        return indices;
    }
}
