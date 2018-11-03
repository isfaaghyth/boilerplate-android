package template

object Fragment {

    fun create(fragmentName: String, packageName: String) =
            "package $packageName\n" +
                    "\n" +
                    "class $fragmentName: Fragment {\n" +
                    "    fun hai(): String {\n" +
                    "        return \"hai!\"\n" +
                    "    }\n" +
                    "}"

}