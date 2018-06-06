package spoon.compiler.builder;


public class ModuleOptions<T extends spoon.compiler.builder.ModuleOptions<T>> extends spoon.compiler.builder.Options<T> {
    public ModuleOptions() {
        super(spoon.compiler.builder.ModuleOptions.class);
    }

    public T modules(java.lang.String modulePath) {
        if (modulePath != null) {
            args.add("--module-source-path");
            args.add(modulePath);
        }
        return myself;
    }
}

