import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Triangle {
    private final Vector3f v1;
    private final Vector3f v2;
    private final Vector3f v3;
    private final Vector3f color;

    public Triangle(Vector3f v1, Vector3f v2, Vector3f v3, Vector3f color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }

    FloatBuffer getCoordArray() {
        FloatBuffer retval = BufferUtils.createFloatBuffer(3*3);
        v1.get(retval.slice(0, 3));
        v2.get(retval.slice(3, 3));
        v3.get(retval.slice(6, 3));
        return retval;
    }

    FloatBuffer getColorArray() {
        FloatBuffer retval = BufferUtils.createFloatBuffer(3*3);
        color.get(retval.slice(0, 3));
        color.get(retval.slice(3, 3));
        color.get(retval.slice(6, 3));
        return retval;
    }

    IntBuffer getIndices() {
        IntBuffer retval = BufferUtils.createIntBuffer(3);
        retval.put(0);
        retval.put(1);
        retval.put(2);
        retval.flip();
        return retval;
    }
}
