package co.anbora.labs.firebase.lang.core.psi.resolve.ref

sealed class Visibility {
    object Public : Visibility()
    object Internal : Visibility()

    /*companion object {
        fun buildSetOfVisibilities(element: FireRuleElement): Set<Visibility> {
            val vs = mutableSetOf<Visibility>(Public)
            val containingModule = element.containingModule
            if (containingModule != null) {
                val asFriendModule = containingModule.fqModule()
                if (asFriendModule != null) {
                    vs.add(PublicFriend(asFriendModule))
                }
            }

            val containingFun = element.containingFunction
            if (containingModule == null
                || (containingFun?.visibility == FunctionVisibility.PUBLIC_SCRIPT)
            ) {
                vs.add(PublicScript)
            }
            return vs
        }
    }*/
}

enum class Namespace {
    NAME,
    TYPE,
    SPEC_ITEM,
    SCHEMA,
    SCHEMA_FIELD,
    MODULE,
    STRUCT_FIELD,
    DOT_ACCESSED_FIELD;
}
