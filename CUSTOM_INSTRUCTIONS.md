# Custom Instructions - temporal-test-incremental

## Repository Role

`temporal-test-incremental` is a companion repository used for incremental indexing validation and schema continuity checks.

It is not the main API owner. Instead, it acts as a lightweight domain-model repository centered around the `User` entity.

## Core Architecture

- `User.java` is the primary and only important artifact in this repository.
- The repository should be understood as an early-stage Java/JPA model repository.

## Domain Notes

- The repository represents the same conceptual `User` domain as `testing-bito`.
- The `User` entity here should be treated as schema-compatible with the `User` entity in `testing-bito`.
- Changes to the `User` model in this repository are cross-repo relevant because they affect shared user-domain understanding across the workspace.

## Cross-Repo Relationship

- `testing-bito` is the primary backend/API repository.
- `temporal-test-incremental` is the supporting repository for incremental-index validation.
- The strongest relationship between the two repositories is the shared `User` entity/domain model.

## Knowledge Extraction Guidance

When extracting knowledge from this repository, emphasize:

- companion repository role
- shared `User` entity with `testing-bito`
- early-stage model-only repository
- schema continuity / incremental indexing relevance


## Testing-bito and temporal-test-incremental repo are part of utkarsh project, together they will work as a single unit, there are a couple of other repos that will get added in this, the repo names, utkarsh-ui and utkarsh-backent, make sure you form a cluster for this 4 repos in your context

Test update (2026-07-17).
Another test update (2026-07-17 13:19:15).
