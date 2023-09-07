import { z } from "zod";

const ClusterSchema = z.object({
  id: z.string(),
  type: z.string(),
  attributes: z.object({
    name: z.string(),
    bootstrapServers: z.string(),
  }),
});
export const Response = z.object({
  data: z.array(ClusterSchema),
});
export type Cluster = z.infer<typeof ClusterSchema>;
export const BookmarkSchema = z.object({
  id: z.string(),
  type: z.string(),
  attributes: z.object({
    name: z.string(),
    bootstrapServer: z.string(),
    principal: z.string(),
    cluster: ClusterSchema.optional(),
    mechanism: z.string(),
  }),
});
export type Bookmark = z.infer<typeof BookmarkSchema>;
const PartitionSchema = z.object({
  partition: z.number(),
  leader: z.object({
    id: z.number(),
    host: z.string(),
    port: z.number(),
  }),
  replicas: z.array(
    z.object({
      id: z.number(),
      host: z.string(),
      port: z.number(),
    }),
  ),
  isr: z.array(
    z.object({
      id: z.number(),
      host: z.string(),
      port: z.number(),
    }),
  ),
  offset: z.object({
    offset: z.number(),
    leaderEpoch: z.number(),
  }),
});
const ConfigSchema = z.object({
  value: z.string(),
  source: z.string(),
  sensitive: z.boolean(),
  readOnly: z.boolean(),
  type: z.string(),
});
const TopicSchema = z.object({
  id: z.string(),
  type: z.string(),
  attributes: z.object({
    name: z.string(),
    internal: z.boolean(),
    partitions: z.array(PartitionSchema),
    authorizedOperations: z.array(z.string()),
    configs: z.record(z.string(), ConfigSchema),
  }),
});
export const TopicsResponse = z.object({
  data: z.array(TopicSchema),
});
export const TopicResponse = z.object({
  data: TopicSchema,
});
export type Topic = z.infer<typeof TopicSchema>;
