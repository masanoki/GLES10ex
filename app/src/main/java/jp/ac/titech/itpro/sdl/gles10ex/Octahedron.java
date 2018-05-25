package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octahedron implements SimpleRenderer.Obj {

    private final static float[] VERTICES = {
            // left top
            -1, 0, -1,
            0, 1, 0,
            -1, 0, 1,
            // right top
            1, 0, -1,
            0, 1, 0,
            1, 0, 1,
            // back top
            -1, 0, -1,
            0, 1, 0,
            1, 0, -1,
            // front top
            -1, 0, 1,
            0, 1, 0,
            1, 0, 1,
            // left bottom
            -1, 0, -1,
            0, -1, 0,
            -1, 0, 1,
            // right bottom
            1, 0, -1,
            0, -1, 0,
            1, 0, 1,
            // back bottom
            -1, 0, -1,
            0, -1, 0,
            1, 0, -1,
            // front bottom
            -1, 0, 1,
            0, -1, 0,
            1, 0, 1
    };

    private final FloatBuffer vbuf;

    Octahedron() {
        vbuf = ByteBuffer.allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // left top
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // right top
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // back top
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // front top
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // left bottom
        gl.glNormal3f(-1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);

        // right bottom
        gl.glNormal3f(1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // back bottom
        gl.glNormal3f(0, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // front bottom
        gl.glNormal3f(0, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);
    }
}
