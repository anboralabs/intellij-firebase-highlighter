package co.anbora.labs.firebase.lang.core.psi.resolve.ref

sealed class Visibility {
    object Public : Visibility()
    object Internal : Visibility()
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
