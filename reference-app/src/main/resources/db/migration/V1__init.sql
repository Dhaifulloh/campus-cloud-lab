CREATE TABLE tenant (
  id BIGSERIAL PRIMARY KEY,
  code VARCHAR(32) NOT NULL UNIQUE,
  name VARCHAR(120) NOT NULL,
  active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE laboratory (
  id BIGSERIAL PRIMARY KEY,
  tenant_code VARCHAR(32) NOT NULL,
  code VARCHAR(32) NOT NULL,
  name VARCHAR(120) NOT NULL,
  capacity INTEGER NOT NULL CHECK (capacity > 0),
  location VARCHAR(120),
  active BOOLEAN NOT NULL DEFAULT TRUE,
  UNIQUE (tenant_code, code)
);

CREATE TABLE reservation (
  id BIGSERIAL PRIMARY KEY,
  tenant_code VARCHAR(32) NOT NULL,
  laboratory_id BIGINT NOT NULL REFERENCES laboratory(id),
  start_time TIMESTAMPTZ NOT NULL,
  end_time TIMESTAMPTZ NOT NULL,
  status VARCHAR(32) NOT NULL,
  purpose VARCHAR(255),
  created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CHECK (end_time > start_time)
);

CREATE TABLE usage_record (
  id BIGSERIAL PRIMARY KEY,
  tenant_code VARCHAR(32) NOT NULL,
  laboratory_id BIGINT NOT NULL REFERENCES laboratory(id),
  reservation_id BIGINT REFERENCES reservation(id),
  started_at TIMESTAMPTZ NOT NULL,
  ended_at TIMESTAMPTZ,
  attendees INTEGER CHECK (attendees >= 0),
  note VARCHAR(255)
);

CREATE TABLE processed_event (
  event_id VARCHAR(64) PRIMARY KEY,
  processed_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);
