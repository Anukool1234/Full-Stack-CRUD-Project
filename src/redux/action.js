import { VIEW_PRODUCT } from "./constant";

export const view = (data) => {
  return {
    type: VIEW_PRODUCT,
    data,
  };
};
