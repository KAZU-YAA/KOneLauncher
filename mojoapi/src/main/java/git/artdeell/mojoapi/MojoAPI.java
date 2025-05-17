package git.artdeell.mojoapi;

/**
 * The main class of the Mojo API, contains most methods.
 */
public class MojoAPI {
    /**
     * Gets the currently selected renderer
     * @return The {@link Renderer} that is currently being used or null if the renderer is not known
     */
    public static Renderer getSelectedRenderer() {
        String rendererString = System.getenv("MOJO_RENDERER");
        Renderer renderer;
        switch (rendererString) {
            case "opengles2":
            case "opengles2_5":
            case "opengles3":
                renderer = Renderer.HOLY_GL4ES; break;
            case "vulkan_zink": renderer = Renderer.ZINK; break;
            case "opengles3_ltw" : renderer = Renderer.LTW; break;
            default: renderer = null; break;
        }
        return renderer;
    }

    /**
     * Gets the force_vsync value from pojav_environ
     * @return Whether vsync is forced or not
     */
    public static native boolean isForceVSync();

    /**
     * Gets the current width
     * @return the width
     */
    public static native int getWidth();

    /**
     * Gets the current height
     * @return the height
     */
    public static native int getHeight();

    static {
        try {
            System.loadLibrary("pojavexec");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }
}
