# Table of Contents

- [Table of Contents](#table-of-contents)

- Cannot "autowire" via constructor/field injection on class/instance/member attributes/fields/variables that have the `@Value` annotation
  - I.e. CANNOT add `@AllArgsConstructor` or `@Autowired` on that field/variable since the variable's value will be dynamically injected by Spring (and we WONT have a global variable/bean to be managed by Spring)
- All values inside `${}` need to have a BACKUP/DEFAULT value using `:` in `${value:defaultValue}`
  - `${CONTEXT + _ + ENV_VAR_ALL_CAPS + :defaultValue}` (note: all occurrences of `-` in CONTEXT become `_`)f
- Do NOT use `jsonNode.get("key").toString()` (it will add EXTRA ESCAPED QUOTES to existing strings)
  - Use `jsonNode.get("key").asText()` instead
- If using `@Value("${parentVal.childVal}")` annotation on MEMBER VARIABLES, we can use `@NoArgsConstructor`
- When using `@ConfigurationProperties(prefix = "asdf")` on CLASS
  - CANNOT use `@NoArgsConstructor` annotation/decorator -> Use `@Getter` and `@Setter` annotations/decorators instead
  - CANNOT use `boolean` type on variables -> Use `Boolean` type instead
