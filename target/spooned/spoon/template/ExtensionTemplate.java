package spoon.template;


public class ExtensionTemplate extends spoon.template.AbstractTemplate<spoon.reflect.declaration.CtType<?>> {
    @java.lang.Override
    public spoon.reflect.declaration.CtType<?> apply(spoon.reflect.declaration.CtType<?> target) {
        spoon.reflect.declaration.CtClass<? extends spoon.template.Template<?>> templateType = spoon.template.Substitution.getTemplateCtClass(target.getFactory(), this);
        spoon.reflect.declaration.CtType<?> generated = spoon.template.TemplateBuilder.createPattern(templateType, templateType, this).setAddGeneratedBy(isAddGeneratedBy()).substituteSingle(target, spoon.reflect.declaration.CtType.class);
        for (spoon.reflect.reference.CtTypeReference<?> iface : new java.util.ArrayList<>(generated.getSuperInterfaces())) {
            iface.delete();
            target.addSuperInterface(iface);
        }
        for (spoon.reflect.declaration.CtTypeMember tm : new java.util.ArrayList<spoon.reflect.declaration.CtTypeMember>(generated.getTypeMembers())) {
            tm.delete();
            target.addTypeMember(tm);
        }
        return target;
    }
}

