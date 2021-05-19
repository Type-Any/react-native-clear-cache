import { foramtFileSize } from '../index';

test('convert to readable file size', () => {
  expect(foramtFileSize(422)).toMatch('422 Bytes');
  expect(foramtFileSize(122304)).toMatch('119.4375 KB');
  expect(foramtFileSize(10000000)).toMatch('9.5367 MB');
  expect(foramtFileSize(87919837478)).toMatch('81.8817 GB');
  expect(foramtFileSize(191238495867681)).toMatch('173.9304 TB');
  expect(foramtFileSize(929292929384748571)).toMatch('825.3779 PB');
  expect(foramtFileSize(9292929293847485728)).toMatch('8.0603 EB');
  expect(foramtFileSize(9292929293847485719928)).toMatch('7.8714 ZB');
  expect(foramtFileSize(13847885919183748857185858)).toMatch('11.4547 YB');
});

test('truncate digit', () => {
  expect(foramtFileSize(122304, -1)).toMatch('119 KB');
  expect(foramtFileSize(122304, 0)).toMatch('119 KB');
  expect(foramtFileSize(122304, 1)).toMatch('119.4 KB');
  expect(foramtFileSize(122304, 2)).toMatch('119.44 KB');
  expect(foramtFileSize(122304, 3)).toMatch('119.438 KB');
  expect(foramtFileSize(122304)).toMatch('119.4375 KB');
  expect(foramtFileSize(122304, 5)).toMatch('119.4375 KB');
});
