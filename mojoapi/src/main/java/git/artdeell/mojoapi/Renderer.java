package git.artdeell.mojoapi;

/**
 * The available renderers in the current API version
 */
public enum Renderer {
    /**
     * Holy GL4ES is the default renderer in MojoLauncher and one of the fastest renderers there is.
     * Incompatible with pretty much anything past OpenGL 2.0+
     */
    HOLY_GL4ES("Holy GL4ES", Backend.OPENGL_ES),
    /**
     * Zink has by far the best compatibility, being compatible with essentially everything since it implements OpenGL 4.6.
     * It is by far the slowest renderer, and might be somewhat buggy due to incomplete or buggy mobile Vulkan driver implementations, such as on Mali GPUs.
     */
    ZINK("Zink", Backend.VULKAN),
    /**
     * LTW, which is short for Little Thin Wrapper, is the fastest renderer that maintains good compatibility. It has been developed by artDev,
     * specifically for PojavLauncher. Supports only 1.17+.
     */
    LTW("LTW", Backend.OPENGL_ES);

    private final String name;
    private final Backend backend;
    Renderer(String name, Backend backend) {
        this.name = name;
        this.backend = backend;
    }

    public String getName() {
        return name;
    }

    public Backend getBackend() {
        return backend;
    }

    @Override
    public String toString() {
        return name + " (" + backend.name + ")";
    }

    public enum Backend {
        /**
         * OpenGL ES, short for Open Graphics Library for Embedded Systems, is a stateful graphics API, based on the desktop OpenGL,
         * but adapted for embedded systems. It has great support on most mobile devices.
         */
        OPENGL_ES("OpenGL ES"),
        /**
         * Vulkan is a low-level graphics API, which is designed to give developers more control over the GPU. It does not manage the state in
         * difference to OpenGL or OpenGL (ES) and, if used correctly, can be much faster than OpenGL or OpenGL ES. It often suffers to bad drivers
         * on mobile devices.
         */
        VULKAN("Vulkan");

        private final String name;

        Backend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
